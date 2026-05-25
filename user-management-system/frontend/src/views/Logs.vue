<template>
  <div class="logs-container">
    <el-card>
      <template #header>
        <span>操作日志</span>
      </template>

      <el-form :inline="true" :model="queryForm">
        <el-form-item label="操作类型">
          <el-select v-model="queryForm.operation" placeholder="请选择" clearable>
            <el-option label="登录" value="LOGIN" />
            <el-option label="创建" value="CREATE" />
            <el-option label="更新" value="UPDATE" />
            <el-option label="删除" value="DELETE" />
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="loadLogs">查询</el-button>
          <el-button @click="resetQuery">重置</el-button>
        </el-form-item>
      </el-form>

      <el-table :data="logList" border stripe v-loading="loading">
        <el-table-column prop="id" label="ID" width="80" />
        <el-table-column prop="userId" label="用户ID" width="100" />
        <el-table-column prop="operation" label="操作类型" width="120" />
        <el-table-column prop="resource" label="资源" width="150" />
        <el-table-column prop="details" label="详情" />
        <el-table-column prop="ipAddress" label="IP地址" width="150" />
        <el-table-column prop="createdAt" label="操作时间" width="180" />
      </el-table>

      <el-pagination
        v-model:current-page="queryForm.page"
        v-model:page-size="queryForm.size"
        :total="total"
        :page-sizes="[10, 20, 50, 100]"
        layout="total, sizes, prev, pager, next, jumper"
        @current-change="loadLogs"
        @size-change="loadLogs"
        style="margin-top: 20px; justify-content: center"
      />
    </el-card>
  </div>
</template>

<script setup lang="ts">
import { ref, reactive, onMounted } from 'vue'
import { getLogs } from '@/api/logs'
import type { OperationLog } from '@/api/types'

const loading = ref(false)
const logList = ref<OperationLog[]>([])
const total = ref(0)

const queryForm = reactive({
  operation: '',
  page: 1,
  size: 10
})

const loadLogs = async () => {
  loading.value = true
  try {
    const res = await getLogs(queryForm)
    logList.value = res.data.content
    total.value = res.data.totalElements
  } catch (error) {
    console.error(error)
  } finally {
    loading.value = false
  }
}

const resetQuery = () => {
  queryForm.operation = ''
  queryForm.page = 1
  loadLogs()
}

onMounted(() => {
  loadLogs()
})
</script>

<style scoped>
.logs-container {
  height: 100%;
}
</style>
