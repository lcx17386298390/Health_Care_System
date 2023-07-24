<template>
  <div class="bg-primary">
    <div id="layoutAuthentication">
      <div id="layoutAuthentication_content">
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-lg-7">
              <div class="card shadow-lg border-0 rounded-lg mt-5">
                <div class="card-header">
                  <h3 class="text-center font-weight-light my-4">
                    创建一个账号
                  </h3>
                </div>
                <div class="card-body">
                  <form>
                    <div class="row mb-3">
                      <div class="col-md-6">
                        <div class="form-floating mb-3 mb-md-0">
                          <input
                            class="form-control"
                            id="inputFirstName"
                            type="text"
                            placeholder="Enter your first name"
                          />
                          <label for="inputFirstName">请输入您的账号...</label>
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="form-floating">
                          <input
                            class="form-control"
                            id="inputLastName"
                            type="text"
                            placeholder="Enter your last name"
                          />
                          <label for="inputLastName">请输入您的姓名...</label>
                        </div>
                      </div>
                    </div>
                    <div class="form-floating mb-3">
                      <input
                        class="form-control"
                        id="inputEmail"
                        type="email"
                        placeholder="name@example.com"
                      />
                      <label for="inputEmail">请输入您的邮箱进行验证...</label>
                    </div>
                    <div class="row mb-3">
                      <div class="col-md-6">
                        <div class="form-floating mb-3 mb-md-0">
                          <input
                            class="form-control"
                            id="inputPassword"
                            type="password"
                            placeholder="Create a password"
                          />
                          <label for="inputPassword">请输入您的密码...</label>
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="form-floating mb-3 mb-md-0">
                          <input
                            class="form-control"
                            id="inputPasswordConfirm"
                            type="password"
                            placeholder="Confirm password"
                          />
                          <label for="inputPasswordConfirm"
                            >再次确认密码...</label
                          >
                        </div>
                      </div>
                    </div>
                    <div class="mt-4 mb-0">
                      <div class="d-grid">
                        <router-link
                          class="btn btn-primary btn-block"
                          to="/login"
                          >注册账号</router-link
                        >
                      </div>
                    </div>
                  </form>
                </div>
                <div class="card-footer text-center py-3">
                  <div class="small">
                    <router-link to="/login"
                      >已经有一个账号了? 去登陆</router-link
                    >
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
</style>