<template>
  <div id="app">
    <div class="back">
      <div class="line"></div>
      <el-menu
          :default-active="activeIndex"
          class="el-menu-demo"
          mode="horizontal"
          @select="handleSelect"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b">
        <el-menu-item index="1">Login</el-menu-item>
        <el-menu-item index="2" :disabled=!$store.state.isLogin>Personal Center</el-menu-item>
      </el-menu>
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
  data() {
    return {
       // activeIndex: '1',
    }
  },
  components: {

  },
  computed:{
    //设置login后导航栏随之变化
    activeIndex:{
      get:function (){
        console.log(this.$route.path)
        const path = this.$route.path.split('/')
        let index = ''
        switch (path[1]) {
          case "login":
            index = '1'
            break;
          case "profile":
            index = '2'
            break;
        }
        return index
      },
      set:function (){

      }
    }
  },
  methods: {
    showProfile() {
      this.$router.push({
        name: 'profile'
      })
    },
    showLogin() {
      this.$router.push({
        name: 'login'
      })
    },
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
      switch (key) {
        case "1":
          this.$router.push({
            name: 'login'
          })
          break;
        case "2":
          this.$router.push({
            name: 'profile'
          })
          break;
      }
    }

  },
  // created() {
  //   console.log(this.$route)
  // }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;

}

.back {
  height: 1000px;
  background-color: #EBEEF5;
  min-width: 1300px;
}

/*main中的导航*/
.el-tabs--top .el-tabs__item.is-top:nth-child(2) {
  padding-left: 20px !important;
}

.el-tabs__item {
  font-size: 16px !important;
}

/*结束*/


.nav {
  height: 50px;
  background-color: #777777;

}

</style>
