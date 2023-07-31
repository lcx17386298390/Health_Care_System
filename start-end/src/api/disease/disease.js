import request from '@/utils/request'

// 查询患者病历列表
export function listDisease(query) {
  return request({
    url: 'http://localhost:8002/disease/disease/list',
    method: 'get',
    params: query
  })
}

// 查询患者病历详细
export function getDisease(id) {
  return request({
    url: 'http://localhost:8002/disease/disease/' + id,
    method: 'get'
  })
}

// 新增患者病历
export function addDisease(data) {
  return request({
    url: 'http://localhost:8002/disease/disease',
    method: 'post',
    data: data
  })
}

// 修改患者病历
export function updateDisease(data) {
  return request({
    url: 'http://localhost:8002/disease/disease',
    method: 'put',
    data: data
  })
}

// 删除患者病历
export function delDisease(id) {
  return request({
    url: 'http://localhost:8002/disease/disease/' + id,
    method: 'delete'
  })
}
