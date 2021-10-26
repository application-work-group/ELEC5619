import VueRouter from "vue-router";
//import { component } from "vue/types/umd";
import loginAndRegister from "../components/login-and-register";
import profile from "../components/profile";
import home from '../views/home'

export default new VueRouter({
    routes:[
        {
            path:'/profile',
            component:profile,
            name:'profile'
        },
        {
            path:"/login",
            component:loginAndRegister,
            name:"login"
        },
        {
            path:'/home',
            component:home,
            name:'home'
        },
        {
            path: '/home/:category',
            name: 'category',
            component: home,
        },
        {
            path: '/home/:category',
            name: 'football',
            component: home,
        },
        {
            path:'/',    //设置默认路由
            component:home,
        }
    ]
})