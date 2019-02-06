const merge = require('webpack-merge');
const common = require('./webpack.config');

module.exports = merge(common, {
    entry: {
        "./src/main/resources/static/scripts/bundle": './webapp/src/main.ts',
    },
    mode: "production"
});