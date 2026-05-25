import request from './request'
import type { ApiResponse, LoginForm, User } from './types'

export interface LoginResponse {
  token: string
  user: User
}

export const login = (data: LoginForm) => {
  return request.post<any, ApiResponse<LoginResponse>>('/auth/login', data)
}
