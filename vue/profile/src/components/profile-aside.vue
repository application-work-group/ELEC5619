<template>
  <div class="aside">
    <div class="asideBox">
      <div class="asideBoxContent" style="border-right: 1px solid #bdbdbd">    <!--可以优化成一个slot-->
        <div>Following</div>
        <div>0</div>
      </div>
      <div class="asideBoxContent">
        <div>Followed</div>
        <div>0</div>
      </div>
    </div>

    <div class="asideBox">
      <div class="asideBoxContent" style="border-right: 1px solid #bdbdbd">
        <div>Point</div>
        <div>100</div>
      </div>
      <div class="asideBoxContent">
        <div>Recommended</div>
        <div>0</div>
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

    }
  },
  components: {
    profileAsideChannel
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