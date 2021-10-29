<template>
  <v-container fluid >
    <v-row >
      <v-col :cols="8">
        <v-row justify="center">
          <v-col :cols="10">
            <carousel/>
          </v-col>
        </v-row>
          <v-row v-for="post in postList" :key="post.id" >
            <v-col>
              <v-card outlined >
                <v-card-title>{{post.title}}</v-card-title>
                <v-card-subtitle>{{post.content}}</v-card-subtitle>
              </v-card>
            </v-col>
          </v-row>

      </v-col>
      <v-col>
        <v-row
        justify="end"
        v-for="item in gameList"
        :key="item.id"
        >
        <v-col :cols="12">
          <v-card outlined color="grey">
            <v-row align="center" justify="center">
              <v-card-title>{{item.home}} vs {{item.away}}</v-card-title>
              <v-card-text>
                <p class="text-h4 text--primary" style="text-align:center">
                  {{item.gameResult}}
                </p>
              </v-card-text>
            </v-row>
            <!-- <v-row
              align="center"
              justify="end"
            >
              <v-card-actions>
                <v-btn icon>
                  <v-icon>mdi-arrow-right-bold</v-icon>
                </v-btn>
              </v-card-actions>
            </v-row> -->
          </v-card>
          </v-col>
        </v-row>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import carousel from "../components/carousel.vue";
export default {
  name: "home",
  components: {
    carousel,
  },
  data() {
    return {
      category: this.$route.params.category,
      gameList:[],
      postList:[] 
    };
  },
  methods: {
    getGameList(){
      this.axios
        .post("http://localhost:8080/game/gameSession/getGameList", {})
        .then((res) => {
          //success
          if (res.data.success) {
            console.log("gamelist=>", res.data.data);
            this.gameList = res.data.data
          }else{
            //fail
            this.$message.error("getGame fail")
          }
        })
        .catch((error) => {
          console.log("error=>", error);
        });
    },
    getPostList(){
      this.axios
        .post("http://localhost:8080/save/post/getPostList", {})
        .then((res) => {
          //success
          if (res.data.success) {
            console.log("postlist=>", res.data.data);
            this.postList = res.data.data
          }else{
            //fail
            this.$message.error("getPost fail")
          }
        })
        .catch((error) => {
          console.log("error=>", error);
        });      
    }
  },
  created() {
    this.getGameList();
    this.getPostList();
  },
};
</script>

