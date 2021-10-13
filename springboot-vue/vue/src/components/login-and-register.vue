<template>
  <div id="container">
    <div class="form-box">
      <div class="button-box">

        <div id="btn" :style="{left:left+'px'}"></div>
        <button type="button" class="toggle-button" @click="switchToLogin">Log in</button>
        <button type="button" class="toggle-button" @click="switchToRegister">Register</button>
      </div>
      <!--登陆-->
      <form class="input-group" v-show="isLoginPage">
        <input type="text" class="input-field" placeholder="User Id" v-model="logInId">
        <input type="password" class="input-field" placeholder="Enter password" v-model="logInPassword">
        <button type="submit" class="submit-btn" @click="login">Log in</button>
        <!--注册-->
      </form>
      <form class="input-group" v-show="!isLoginPage">
        <input type="text" class="input-field" placeholder="User Id" v-model="registerInfo.userName">
        <input type="text" class="input-field" placeholder="User email" v-model="registerInfo.email">
        <input type="text" class="input-field" placeholder="phone number" v-model="registerInfo.phoneNumber">
        <input type="password" class="input-field" placeholder="Enter password" v-model="registerInfo.password">
        <button type="submit" class="submit-btn" @click="register">Register</button>

      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "login-and-register",
  data() {
    return {
      registerInfo: {
        userName: '',
        email: '',
        password: '',
        phoneNumber: '',
      },
      loginInfo:{
        Id:'',
        password:''
      },
      isLoginPage: true,
      left: 0,
    }
  },
  methods: {
    register() {
      //简单判断信息是否为空
      if (this.registerInfo.password.trim() === '') {
        alert('no password')
        return;
      }
      if (this.registerInfo.userName.trim() === '') {
        alert('no userID')
        return;
      }
      if (this.registerInfo.email.trim() === '') {
        alert('no email')
        return;
      }
      if (this.registerInfo.phoneNumber.trim() === '') {
        alert('no phone')
        return;
      }
      //提交注册信息
      // this.axios({
      //   url:"http://localhost:8080/save/userInfo/saveUserInfo",
      //   method:"post",
      //   data:{
      //     userName: 'aaa',
      //     email: 'bbb',
      //     password: 'ccc',
      //     phoneNumber: 'ddd',
      //   },
      //   headers: {
      //     'Content-Type':'application/json'
      //   }
      // })
      this.axios.post('http://localhost:8080/save/userInfo/saveUserInfo', this.registerInfo
      ).then(res => {
        console.log('res=>', res);
      })
          .catch((error) => {
            console.log('error=>', error)
          })
      alert('success')
    },
    login() {
      this.axios.post('http://localhost:8080/save/userInfo/userLogin', {
        userName:this.loginInfo.Id,
        phoneNumber:'',
        email:'',
        password:this.loginInfo.password
          }
      ).then(res => {
        console.log('res=>', res);
      })
          .catch((error) => {
            console.log('error=>', error)
          })
      //修改登陆状态
      this.$store.commit('login', true)
      this.$router.push({
        name: 'profile'
      })
    },
    switchToLogin() {
      //切换登陆和注册界面
      this.isLoginPage = true
      this.left = 0
      //
    },
    switchToRegister() {
      //切换登陆和注册界面
      this.isLoginPage = false
      this.left = 110
    }
  },
  // created() {
  //
  // }
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

.toggle-button {
  padding: 10px 30px;
  cursor: pointer; /*不知道*/
  background: transparent; /*不知道*/
  border: 0;
  outline: none;
  position: relative;
}

#btn { /*用来填充颜色的，不会覆盖住底下的内容，而是一起显示*/
  top: 0;
  left: 0px;
  position: absolute;
  width: 110px;
  height: 100%;
  background: linear-gradient(to right, #42b983, #a4eccc);
  border-radius: 30px; /*圆角，和上面保持一致*/
  transition: .5s;
}

.input-group {
  left: 50px;
  top: 140px;
  position: absolute;
  width: 280px;
  transition: .5s;
}

.input-field {
  width: 100%;
  padding: 10px 0;
  margin: 5px 0;
  border-left: 0;
  border-right: 0;
  border-top: 0;
  border-bottom: 1px solid #999;
  outline: none; /*外边框*/
  background: transparent;
}

.submit-btn {
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