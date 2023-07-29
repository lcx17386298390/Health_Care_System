const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  configureWebpack: {
    resolve: {
      fallback: {
        path: false
      }
    }
  }
})
const NodePolyfillPlugin = require('node-polyfill-webpack-plugin')




