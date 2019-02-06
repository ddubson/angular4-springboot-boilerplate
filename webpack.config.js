var path = require('path')

module.exports = {
    entry: {
        "./src/main/resources/static/scripts/bundle": './webapp/src/main.ts',
        "./webapp/test/bundle/testbundle": './webapp/test/test_index.js'
    },
    output: {
        filename: '[name].js',
        libraryTarget: 'var',
        library: ''
    },
    resolve: {
        modules: [
            path.resolve(__dirname, 'webapp'),
            'node_modules'
        ],
        extensions: ['.js', '.ts']
    },
    module: {
        rules: [
            {
                test: /\.[jt]s$/,
                exclude: /node_modules/,
                loader: 'babel-loader',
                options: {
                    presets: ['@babel/env']
                }
            },
            {
                test: /\.ts$/,
                loader: 'ts-loader',
                exclude: /node_modules/
            },
            {test: /\.css$/, loaders: 'style-loader!css-loader'}
        ]
    }
};