import request from './request'
import type { ApiResponse, PageData, User } from './types'

export interface UserQuery {
  keyword?: string
  status?: string
  departmentId?: number
  page?: number
  size?: number
  sortBy?: string
  sortDir?: string
}

export interface CreateUserForm {
  username: string
  email: string
  phone?: string
  password: string
  fullName?: string
  avatar?: string
  bio?: string
  departmentId?: number
  roleIds?: number[]
}

export interface UpdateUserForm {
  email?: string
  phone?: string
  fullName?: string
  avatar?: string
  bio?: string
  departmentId?: number
  password?: string
  roleIds?: number[]
}

export const getUsers = (params: UserQuery) => {
  return request.get<any, ApiResponse<PageData<User>>>('/users', { params })
}

export const getUserById = (id: number) => {
  return request.get<any, ApiResponse<User>>(`/users/${id}`)
}

export const createUser = (data: CreateUserForm) => {
  return request.post<any, ApiResponse<User>>('/users', data)
}

export const updateUser = (id: number, data: UpdateUserForm) => {
  return request.put<any, ApiResponse<User>>(`/users/${id}`, data)
}

export const deleteUser = (id: number) => {
  return request.delete<any, ApiResponse<void>>(`/users/${id}`)
}

export const updateUserStatus = (id: number, status: string) => {
  return request.patch<any, ApiResponse<void>>(`/users/${id}/status`, null, {
    params: { status }
  })
}
