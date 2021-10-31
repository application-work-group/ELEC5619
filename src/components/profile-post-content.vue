<template>
  <div>
    <el-table @cell-click="handleClick"
              height="400"
        :data="content"
        style="width: 100%">
      <el-table-column width="30"></el-table-column>
      <el-table-column
          prop="title"
          label="title"
          width="450">
      </el-table-column>
<!--      <el-table-column-->
<!--          prop="reply"-->
<!--          label="reply"-->
<!--          width="180">-->
<!--      </el-table-column>-->
      <el-table-column
          prop="channel"
          label="channel">
      </el-table-column>

    </el-table>




  </div>
</template>

<script>
export default {
  name: "profile-post-content",
  methods:{
    handleClick(row, column, event,cell){
      console.log("row = ",row)
      console.log("col = ",column)
      console.log("event = ",event)
      console.log("cell = ",cell)
      console.log(this.content)
      window.location.href='http://localhost:8080/post-info/post?postId='+row.Id
    }
  },
  props:['content'],
}
</script>

<style scoped>

</style>