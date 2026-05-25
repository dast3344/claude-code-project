<template>
  <div class="departments-container">
    <el-card>
      <template #header>
        <div class="card-header">
          <span>部门管理</span>
          <el-button type="primary" @click="handleAdd">新增部门</el-button>
        </div>
      </template>

      <el-table :data="departmentList" border stripe v-loading="loading" row-key="id" default-expand-all>
        <el-table-column prop="id" label="ID" width="80" />
        <el-table-column prop="name" label="部门名称" width="200" />
        <el-table-column prop="description" label="描述" />
        <el-table-column label="操作" width="200" fixed="right">
          <template #default="{ row }">
            <el-button type="primary" link @click="handleEdit(row)">编辑</el-button>
            <el-button type="danger" link @click="handleDelete(row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>

    <el-dialog
      v-model="dialogVisible"
      :title="isEdit ? '编辑部门' : '新增部门'"
      width="500px"
      @close="resetForm"
    >
      <el-form :model="formData" :rules="rules" ref="formRef" label-width="100px">
        <el-form-item label="部门名称" prop="name">
          <el-input v-model="formData.name" />
        </el-form-item>
        <el-form-item label="上级部门">
          <el-tree-select
            v-model="formData.parentId"
            :data="departmentTreeData"
            :props="{ label: 'name', value: 'id' }"
            placeholder="请选择上级部门"
            clearable
            check-strictly
          />
        </el-form-item>
        <el-form-item label="描述">
          <el-input v-model="formData.description" type="textarea" />
        </el-form-item>
      </el-form>
      <template #footer>
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="handleSubmit">确定</el-button>
      </template>
    </el-dialog>
  </div>
</template>

<script setup lang="ts">
import { ref, reactive, onMounted } from 'vue'
import { ElMessage, ElMessageBox, type FormInstance } from 'element-plus'
import { getDepartments, createDepartment, updateDepartment, deleteDepartment } from '@/api/departments'
import type { Department } from '@/api/types'

const loading = ref(false)
const departmentList = ref<Department[]>([])
const departmentTreeData = ref<any[]>([])
const dialogVisible = ref(false)
const isEdit = ref(false)
const formRef = ref<FormInstance>()

const formData = reactive({
  name: '',
  parentId: undefined as number | undefined,
  description: ''
})

const rules = {
  name: [{ required: true, message: '请输入部门名称', trigger: 'blur' }]
}

let currentDepartmentId: number | null = null

const loadDepartments = async () => {
  loading.value = true
  try {
    const res = await getDepartments()
    departmentList.value = res.data
    departmentTreeData.value = buildTree(res.data)
  } catch (error) {
    console.error(error)
  } finally {
    loading.value = false
  }
}

const buildTree = (departments: Department[]) => {
  const map = new Map()
  const tree: any[] = []

  departments.forEach(dept => {
    map.set(dept.id, { ...dept, children: [] })
  })

  departments.forEach(dept => {
    const node = map.get(dept.id)
    if (dept.parentId && map.has(dept.parentId)) {
      map.get(dept.parentId).children.push(node)
    } else {
      tree.push(node)
    }
  })

  return tree
}

const handleAdd = () => {
  isEdit.value = false
  currentDepartmentId = null
  dialogVisible.value = true
}

const handleEdit = (row: Department) => {
  isEdit.value = true
  currentDepartmentId = row.id
  Object.assign(formData, {
    name: row.name,
    parentId: row.parentId || null,
    description: row.description || ''
  })
  dialogVisible.value = true
}

const handleDelete = async (row: Department) => {
  try {
    await ElMessageBox.confirm('确定要删除该部门吗?', '提示', {
      type: 'warning'
    })
    await deleteDepartment(row.id)
    ElMessage.success('删除成功')
    loadDepartments()
  } catch (error) {
    if (error !== 'cancel') {
      console.error(error)
    }
  }
}

const handleSubmit = async () => {
  if (!formRef.value) return
  await formRef.value.validate(async (valid) => {
    if (valid) {
      try {
        if (isEdit.value && currentDepartmentId) {
          await updateDepartment(currentDepartmentId, formData)
          ElMessage.success('更新成功')
        } else {
          await createDepartment(formData)
          ElMessage.success('创建成功')
        }
        dialogVisible.value = false
        loadDepartments()
      } catch (error) {
        console.error(error)
      }
    }
  })
}

const resetForm = () => {
  formRef.value?.resetFields()
  Object.assign(formData, {
    name: '',
    parentId: undefined,
    description: ''
  })
}

onMounted(() => {
  loadDepartments()
})
</script>

<style scoped>
.departments-container {
  height: 100%;
}

.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
</style>
