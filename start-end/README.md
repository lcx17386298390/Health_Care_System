# front-end-medical

Homeview是主页面，也就是首页
    首页要求有介绍内容什么的
    主要是要包括 在线咨询，点了咨询提示登录注册

views下有三个系统文件夹，先做病人的
病人文件下内容如下：
    病人的父组件index：patientView //按照需求改组件
                                            //example //放了一个样例
    其他的文件夹对应子组件，子组件有自己的index，和其他的东西
    一律按照父子组件的形式来写。
    1/挂号流程  regisProcess
    2/预约挂号  bookingRegis
    3/订单状况  orderStatus
    4/病史查询  history
    5/处方单    prescription
    6/买药品  buyDrug

## !!项目启动事项!!；拉取完后严格执行
```
yarn install +yarn serve + yarn build
```
跑完三个后你的文件目录应该有dist和modules，dist不是空的,确认你的.gitignore忽略了dist和module，不要传十万行上去了。改变分支大于100+就该全部弃改
//添加额外依赖是使用 yarn add + 依赖名

### Compiles and hot-reloads for development !!!
```
 ！使用yarn启动项目而不是npm ！
```

### Lints and fixes files
```
yarn lint
```

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).
