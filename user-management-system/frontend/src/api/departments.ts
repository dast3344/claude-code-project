import request from './request'
import type { ApiResponse, Department } from './types'

export const getDepartments = () => {
  return request.get<any, ApiResponse<Department[]>>('/departments')
}

export const getDepartmentTree = (parentId?: number) => {
  return request.get<any, ApiResponse<Department[]>>('/departments/tree', {
    params: { parentId }
  })
}

export const getDepartmentById = (id: number) => {
  return request.get<any, ApiResponse<Department>>(`/departments/${id}`)
}

export const createDepartment = (data: Partial<Department>) => {
  return request.post<any, ApiResponse<Department>>('/departments', data)
}

export const updateDepartment = (id: number, data: Partial<Department>) => {
  return request.put<any, ApiResponse<Department>>(`/departments/${id}`, data)
}

export const deleteDepartment = (id: number) => {
  return request.delete<any, ApiResponse<void>>(`/departments/${id}`)
}
