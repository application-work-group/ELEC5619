<template>
  <div class = "main">
    <el-tabs v-model="activeName" @tab-click="handleClick">
      <el-tab-pane :key="item.id" v-for="(item) in editableTabs" :name="item.id" >
        <span slot="label" ><i :class="item.icon"></i>{{item.label}}</span>
        <profile-post-content :content="item.content"/>  <!--最后一个关注的人格式不对，之后再改,用v-if可以，或者tabs数组只写前三个，最后一个单写-->
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
import ProfilePostContent from "@/components/profile-post-content";
export default {
  name: "profile-main",
  components:{
    ProfilePostContent,
  },
  data() {
    return {
      activeName: '1',
      test:"",
      editableTabs:[{
        id : "1",
        label:'Post',
        content:[{title:'5 years from now, tell me which player will be one of the best players ever',reply:'33',channel:'football'},{title:'The Shoe Mega-Thread. All Shoe Questions Here.',reply:'14',channel:'basketball'}],
        icon:'el-icon-s-order'
      },{
        id:"2",
        label:'Reply',
        content:[{title:'Do you think Bayern Munchen are too good for the bundesliga?',reply:'8',channel:'football'},{title:'What past or present player does Anthony Edwards remind you of?',reply:'74',channel:'basketball'}],
        icon:'el-icon-s-comment'
      },{
        id:"3",
        label:"Favorite",
        content:[],
        icon:'el-icon-s-flag'
      },{
        id:"4",
        label:"Following",
        content:[],
        icon:'el-icon-s-custom'
      }]
    };
  },
  methods: {
    handleClick(tab, event) {
      console.log(tab.name, event);
    },
    created(){

    }
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



</style>