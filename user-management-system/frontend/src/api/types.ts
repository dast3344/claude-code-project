export interface LoginForm {
  username: string
  password: string
}

export interface User {
  id: number
  username: string
  email: string
  phone?: string
  fullName?: string
  avatar?: string
  bio?: string
  departmentId?: number
  status: string
  lastLoginTime?: string
  createdAt: string
  updatedAt: string
  roles?: string[]
}

export interface Role {
  id: number
  name: string
  description: string
  createdAt: string
  updatedAt: string
}

export interface Department {
  id: number
  name: string
  parentId?: number
  description?: string
  createdAt: string
  updatedAt: string
}

export interface OperationLog {
  id: number
  userId?: number
  operation: string
  resource?: string
  details?: string
  ipAddress?: string
  createdAt: string
}

export interface ApiResponse<T> {
  code: number
  message: string
  data: T
}

export interface PageData<T> {
  content: T[]
  totalElements: number
  totalPages: number
  size: number
  number: number
}
