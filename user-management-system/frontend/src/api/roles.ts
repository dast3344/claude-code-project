import request from './request'
import type { ApiResponse, Role } from './types'

export const getRoles = () => {
  return request.get<any, ApiResponse<Role[]>>('/roles')
}

export const getRoleById = (id: number) => {
  return request.get<any, ApiResponse<Role>>(`/roles/${id}`)
}

export const getUserRoles = (userId: number) => {
  return request.get<any, ApiResponse<Role[]>>(`/roles/user/${userId}`)
}

export const createRole = (data: Partial<Role>) => {
  return request.post<any, ApiResponse<Role>>('/roles', data)
}

export const updateRole = (id: number, data: Partial<Role>) => {
  return request.put<any, ApiResponse<Role>>(`/roles/${id}`, data)
}

export const deleteRole = (id: number) => {
  return request.delete<any, ApiResponse<void>>(`/roles/${id}`)
}
