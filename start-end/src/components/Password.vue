<template>
  <div class="bg-primary">
    <div id="layoutAuthentication">
      <div id="layoutAuthentication_content">
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-lg-5">
              <div class="card shadow-lg border-0 rounded-lg mt-5">
                <div class="card-header">
                  <h3 class="text-center font-weight-light my-4">
                    密码重置
                  </h3>
                </div>
                <div class="card-body">
                  <div class="small mb-3 text-muted">
                    输入您的邮箱地址,我们将给您一个链接...
                  </div>
                  <form>
                    <div class="form-floating mb-3">
                      <input
                        class="form-control"
                        id="inputEmail"
                        type="email"
                        placeholder="name@example.com"
                      />
                      <label for="inputEmail">请输入您的邮箱...</label>
                    </div>
                    <div
                      class="d-flex align-items-center justify-content-between mt-4 mb-0"
                    >
                      <router-link class="small" to="/login"
                        >返回登录</router-link
                      >
                      <router-link class="btn btn-primary" to="/login"
                        >重置密码</router-link
                      >
                    </div>
                  </form>
                </div>
                <div class="card-footer text-center py-3">
                  <div class="small">
                    <router-link to="/register"
                      >还没有账号? 去注册!</router-link
                    >
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div id="layoutAuthentication_footer">
        <footer class="py-4 bg-light mt-auto">
          <div class="container-fluid px-4">
            <div
              class="d-flex align-items-center justify-content-between small"
            >
              <div class="text-muted">Copyright &copy; Your Website 2023</div>
              <div>
                <router-link to="/#">Privacy Policy</router-link>
                &middot;
                <router-link to="/#">Terms &amp; Conditions</router-link>
              </div>
            </div>
          </div>
        </footer>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
</style>