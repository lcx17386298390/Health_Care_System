// axios-config.js
import axios from 'axios';
import { Loading } from 'element-ui';

let loadingInstance = null;

axios.interceptors.request.use(
    (config) => {
        loadingInstance = Loading.service({
            fullscreen: true, 
            lock: true, 
            text: 'Loading...',
            background: 'rgba(0, 0, 0, 0.7)',
        });
        return config;
    },
    (error) => {
        loadingInstance.close(); 
        return Promise.reject(error);
    }
);

axios.interceptors.response.use(
    (response) => {
        loadingInstance.close();
        return response;
    },
    (error) => {
        loadingInstance.close();
        return Promise.reject(error);
    }
);

export default axios;
