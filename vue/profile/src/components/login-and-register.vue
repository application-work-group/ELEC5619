<template>
  <div id="container">
    <div class="form-box">
      <div class="button-box">

        <div id = "btn" :style = "{left:left+'px'}"></div>
        <button type="button" class="toggle-button" @click="login">Log in </button>
        <button type="button" class="toggle-button" @click="register">Register </button>
      </div>
      <!--登陆-->
      <form class="input-group" v-show="isLogin">
        <input type="text" class = "input-field" placeholder="User Id"  v-model="logInId">
        <input type="password" class = "input-field" placeholder="Enter password" v-model="logInPassword">
        <button type="submit" class="submit-btn">Log in</button>
        <!--注册-->
      </form>
      <form class="input-group" v-show="!isLogin">
        <input type="text" class = "input-field" placeholder="User Id" v-model="registerId">
        <input type="text" class = "input-field" placeholder="User email" v-model="registerEmail">
        <input type="text" class="input-field" placeholder="phone number" v-model="registerPhone">
        <input type="password" class = "input-field" placeholder="Enter password" v-model="registerPassword">
        <button type="submit" class="submit-btn">Register</button>

      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "login-and-register",
  data(){
    return{
      logInId:'',
      logInPassword:'',
      registerId:'',
      registerEmail:'',
      registerPassword:'',
      registerPhone:'',
      isLogin:true,
      left:0,
    }
  },
  methods:{
    register(){
      this.isLogin = false
      this.left = 110
    },
    login(){
      this.isLogin = true
      this.left = 0
    }
  }
}
</script>

<style scoped>
#container {
  text-align: center;
  color: #2c3e50;
  margin: 0;
  padding: 0;

  height: 1000px;
  width: 100%;
  background-image: linear-gradient(to bottom, rgba(0, 0, 0, 0.4), rgba(0, 0, 0, 0.4)), url(../assets/background.jpg);
  background-position: center;
  background-size: cover;
  position: relative;
}

* {
  margin: 0;
  padding: 0;
}

.hero {

}

.form-box {
  width: 380px;
  height: 480px;
  background: #fff;
  position: absolute;
  top: 200px;
  left: 50%;
  margin: auto auto auto -190px;
  padding: 5px;
}

.button-box {
  width: 220px;
  margin: 35px auto;
  position: relative;
  box-shadow: 0 0 20px 9px #ff61241f;
  border-radius: 30px;
}

.toggle-button{
  padding: 10px 30px;
  cursor: pointer;      /*不知道*/
  background: transparent;    /*不知道*/
  border: 0;
  outline: none;
  position: relative;
}

#btn{     /*用来填充颜色的，不知道为什么，不会覆盖住底下的内容，而是一起显示*/
  top:0;
  left: 0px;
  position: absolute;
  width: 110px;
  height: 100%;
  background: linear-gradient(to right,#42b983, #a4eccc);
  border-radius: 30px;     /*圆角，和上面保持一致*/
  transition: .5s;    /*转换时间，不知道啥意思*/
}

.input-group{
  left: 50px;
  top:140px;
  position: absolute;
  width: 280px;
  transition: .5s;
}

.input-field{
  width: 100%;
  padding: 10px 0;
  margin: 5px 0;
  border-left: 0;
  border-right: 0;
  border-top: 0;
  border-bottom: 1px solid #999;
  outline: none;     /*外边框*/
  background: transparent;
}

.submit-btn{
  width: 85%;
  padding: 10px 30px;
  cursor: pointer;
  display: block;
  margin: auto;
  border: 0;
  outline: none;
  border-radius: 30px;
}
</style>