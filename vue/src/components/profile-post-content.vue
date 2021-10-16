<template>
  <div>
    <el-table @row-click="handleClick"
        :data="content"
        style="width: 100%">
      <el-table-column width="30"></el-table-column>
      <el-table-column
          prop="title"
          label="title"
          width="450">
      </el-table-column>
      <el-table-column
          prop="reply"
          label="reply"
          width="180">
      </el-table-column>
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
    handleClick(row, column, event){
      console.log(row)
      console.log(column)
      console.log(event)
    }
  },
  props:['content']

}
</script>

<style scoped>

</style>