const path = require('path');

module.exports = {
    output: {
        filename: '[name].js',
        chunkFilename: '[name].chunk.js',
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