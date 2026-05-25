import request from './request'
import type { ApiResponse, PageData, OperationLog } from './types'

export interface LogQuery {
  userId?: number
  operation?: string
  startTime?: string
  endTime?: string
  page?: number
  size?: number
}

export const getLogs = (params: LogQuery) => {
  return request.get<any, ApiResponse<PageData<OperationLog>>>('/logs', { params })
}

export const getLogById = (id: number) => {
  return request.get<any, ApiResponse<OperationLog>>(`/logs/${id}`)
}
