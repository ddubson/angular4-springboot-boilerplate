const merge = require('webpack-merge');
const common = require('./webpack.config');

module.exports = merge(common, {
    entry: {
        "./webapp/test/bundle/testbundle": './webapp/test/test_index.js'
    },
    mode: "development"
});