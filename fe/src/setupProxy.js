const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function(app) {
  app.use(createProxyMiddleware('/java', { target: 'http://localhost:8061/api/',changeOrigin: true, pathRewrite: { '^/java': '' } }));
  app.use(createProxyMiddleware('/node', { target: 'http://127.0.0.1:4999/', changeOrigin: true, pathRewrite: { '^/node': '' } }));
};