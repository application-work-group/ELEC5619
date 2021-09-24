<template>
  <div id="app">
    <div class="back">
      <div class="nav">
        <span>导航暂时这样，没写样式：</span><button @click = "showLogin">登陆</button> <button @click = "showProfile"> 个人 </button>   <!--暂时没写样式-->
      </div>
      <router-view></router-view>
    </div>           
    </div>

</template>

<script>


// import loginAndRegister from "@/components/login-and-register"
// import profile from "@/components/profile";
// import axios from "axios";
export default {
  name: 'App',
  components: {

    // profile,
    // loginAndRegister
  },
  methods:{
    showProfile(){
      this.$router.push({
        name:'profile'
      })
    },
    showLogin(){
      this.$router.push({
        name:'login'
      })
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;

}
.back{
  height: 1000px;
  background-color: #EBEEF5;
  min-width: 1300px;
}
/*main中的导航*/
.el-tabs--top .el-tabs__item.is-top:nth-child(2) {
  padding-left: 20px !important;
}
.el-tabs__item{
  font-size: 16px !important;
}
/*结束*/


.nav {
  height: 50px;
  background-color: #777777;

}

</style>
