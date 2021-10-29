import VueRouter from "vue-router";
import loginAndRegister from "../components/login-and-register";
import profile from "../components/profile";
import home from "@/components/home";

const router = new VueRouter({
    routes:[
        {
            path:"/profile",
            component:profile,
            name:"profile",
            meta:{isAuth:true}
        },
        {
            path:"/login",
            component:loginAndRegister,
            name:"login"
        },
        {
            path:"/home",
            component:home,
            name:"home"
        },
        {
            path:"/home/football",
            component:home,
            name:"football"
        },
        {
            path:"/home/basketball",
            component:home,
            name:"basketball"
        },
        {
            path:'/',    //设置默认路由
            redirect:'login'
        }
    ]
})
//Global Before Guards
router.beforeEach((to, from, next)=>{
    if(to.meta.isAuth){
        if(sessionStorage.getItem('isLogin')){
            next()
        }else{
            alert('can not access personal center, please login first')
            router.push({name:'login'})
        }
    }else {
        next()
    }
})

export default router