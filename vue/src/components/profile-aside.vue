<template>
  <div class="aside">
    <div class="asideBox">
      <div class="asideBoxContent" style="border-right: 1px solid #bdbdbd">    <!--可以优化成一个slot-->
        <div>Post</div>
        <div>{{postNumber}}</div>
      </div>
      <div class="asideBoxContent">
        <div>Following</div>
        <div>{{following}}</div>
      </div>
    </div>

    <div class="asideBox">
      <div class="asideBoxContent" style="border-right: 1px solid #bdbdbd">
        <div>Points</div>
        <div>{{score}}</div>
      </div>
      <div class="asideBoxContent">
        <div>Points Ranking</div>
        <div>{{ranking}}</div>
      </div>

    </div>
    <profile-aside-channel/>
  </div>
</template>

<script>
import profileAsideChannel from "@/components/profile-aside-channel"

export default {
  name: "profile-aside",
  data() {
    return {
      score: 0,
      postNumber:0,
      following:2,
      ranking:3
    }
  },
  components: {
    profileAsideChannel
  },
  mounted() {
    this.$bus.$on('sendScore',(data)=>{this.score = data})
    this.$bus.$on('sendPost',(data)=>{this.postNumber = data})
  }

}
</script>

<style scoped>
.aside {
  display: inline-block;
  width: 425px;
  height: 760px;
  background-color: #EBEEF5;
  overflow: hidden;
}

.asideBox {
  height: 100px;
  width: 425px;
  background-color: #ffffff;
  margin-bottom: 25px;
}

.asideBoxContent {
  height: 80px;
  width: 211px;
  margin: 10px 0px;
  display: inline-block;
  text-align: center;
  line-height: 40px;
}


</style>