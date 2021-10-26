<template>
  <div class="main">
    <el-tabs v-model="activeName" @tab-click="handleClick">
      <el-tab-pane :key="item.id" v-for="(item) in editableTabs" :name="item.id">
        <span slot="label"><i :class="item.icon"></i>{{ item.label }}</span>
        <profile-post-content :content="item.content"/>  <!--最后一个关注的人格式不对，之后再改,用v-if可以，或者tabs数组只写前三个，最后一个单写-->
      </el-tab-pane>

      <el-tab-pane name="5">   <!--这个是最后的个人信息，包括修改等，和前面的格式不同-->
        <span slot="label"><i class="el-icon-user"></i>personal Information</span>
        <div class="personalInfo">

          <el-form ref="form" :model="form" label-width="110px" @submit.native.prevent>
            <el-form-item label="Id">
              <el-input v-model="Id" disabled="true"></el-input>
            </el-form-item>
            <el-form-item label="old password">
              <el-input v-model="form.password"></el-input>
            </el-form-item>
            <el-form-item label="new password">
              <el-input v-model="form.newPassword"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="changePassword" >Change password</el-button>
            </el-form-item>
          </el-form>
        </div>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
import ProfilePostContent from "@/components/profile-post-content";

export default {
  name: "profile-main",
  components: {
    ProfilePostContent,
  },
  data() {
    return {
      activeName: '1',
      isEdit: false,
      test: "",
      form: {
        password: '',
        newPassword:'',
      },
      editableTabs: [{
        id: "1",
        label: 'Post',
        content: [{
          title: '5 years from now, tell me which player will be one of the best players ever',
          reply: '33',
          channel: 'football'
        }, {title: 'The Shoe Mega-Thread. All Shoe Questions Here.', reply: '14', channel: 'basketball'}],
        icon: 'el-icon-s-order'
      }, {
        id: "2",
        label: 'Reply',
        content: [{
          title: 'Do you think Bayern Munchen are too good for the bundesliga?',
          reply: '8',
          channel: 'football'
        }, {
          title: 'What past or present player does Anthony Edwards remind you of?',
          reply: '74',
          channel: 'basketball'
        }],
        icon: 'el-icon-s-comment'
      }, {
        id: "3",
        label: "Favorite",
        content: [],
        icon: 'el-icon-s-flag'
      }, {
        id: "4",
        label: "Following",
        content: [],
        icon: 'el-icon-s-custom'
      }]
    };
  },
  computed:{
    Id(){
      return this.$store.state.userName
    }
  },
  methods: {
    handleClick(tab, event) {
      console.log(tab.name, event);
    },
    changePassword() {
      this.isEdit = false;
      console.log('submit!');
      this.axios.post('http://localhost:8080/save/userInfo/userLogin', {
            userName:this.Id,
            phoneNumber:'',
            email:'',
            password:this.form.password
          }
      ).then(res => {
        console.log('login res=>', res);
        if(res.data.data === true){
          if(this.form.password === this.form.newPassword){
            alert('The new password cannot be the same as the old password')
            return
          }
          this.axios.get('http://localhost:8080/save/userInfo/modifyPassword', {
                params: {
                  userName: this.Id,
                  password: this.form.newPassword
                },
              }
          ).then(res => {
            console.log('change password res=>', res);
            if(res.data.data === true){
              alert('change success')
            }
          }).catch((error) => {
            console.log('error=>', error)
          })
        }else {
          alert('user name or password is incorrect')
        }
      })
    },
    getUserInformation() {
      this.axios.get('http://localhost:8080/save/userInfo/queryUserInfo', {
            params: {
              userName: this.Id,
            },
          }
      ).then(res => {
        console.log('user information res=>', res);
      }).catch((error) => {
        console.log('error=>', error)
      })
    }
  },
  mounted() {
    //可能要加一个判断是否现在是在登陆
    this.getUserInformation()
  }
}
</script>

<style scoped>
.main {
  display: inline-block;
  width: 800px;
  height: 760px;
  background-color: #ffffff;
  margin-right: 25px;
  float: left;
}

.personalInfo {
  width: 700px;
  height: 500px;
  margin-left: 30px;
}

</style>