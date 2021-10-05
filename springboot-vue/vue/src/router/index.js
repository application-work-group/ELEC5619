import VueRouter from "vue-router";
import loginAndRegister from "../components/login-and-register";
import profile from "../components/profile";

export default new VueRouter({
    routes:[
        {
            path:"/profile",
            component:profile,
            name:"profile"
        },
        {
            path:"/login",
            component:loginAndRegister,
            name:"login"
        },
        {
            path:'/',    //设置默认路由
            redirect:'login'
        }
    ]
})