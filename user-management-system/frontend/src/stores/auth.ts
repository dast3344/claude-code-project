import { defineStore } from 'pinia'
import { ref } from 'vue'
import { login } from '@/api/auth'
import type { LoginForm, User } from '@/api/types'

export const useAuthStore = defineStore('auth', () => {
  const token = ref<string>(localStorage.getItem('token') || '')
  const user = ref<User | null>(null)

  const setToken = (newToken: string) => {
    token.value = newToken
    localStorage.setItem('token', newToken)
  }

  const setUser = (newUser: User) => {
    user.value = newUser
  }

  const loginAction = async (loginForm: LoginForm) => {
    const res = await login(loginForm)
    setToken(res.data.token)
    setUser(res.data.user)
  }

  const logout = () => {
    token.value = ''
    user.value = null
    localStorage.removeItem('token')
  }

  return {
    token,
    user,
    setToken,
    setUser,
    loginAction,
    logout
  }
})
