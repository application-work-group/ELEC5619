<template>
    <v-container fluid>
      <v-row>
        <v-col :cols="10">
          <v-row justify="center">
            <v-col :cols="7"> 
              <carousel/>
            </v-col>
          </v-row>
          <v-row v-for="n in 3" :key="n">
              <v-col v-for="a in 2" :key="a">
                <v-card
                  outlined
                  tile
                >
                  {{category}}
                </v-card>
              </v-col>
          </v-row>
        </v-col>
        <v-col>
          <div v-for="n in 5" :key="n">
            <v-card outlined tile>kapian</v-card>
          </div>
        </v-col>
      </v-row>
    </v-container>
</template>

<script>
import carousel from '../components/carousel.vue'
  export default {
    name: 'home',
    components: {
      carousel
    },
    data(){
      return{
        category: this.$route.params.category
       }
    },
    methods:{

    },
    created(){
       console.log("abcd")
      //   this.axios.get('http://localhost:8080/getPostList', {
      //   }
      // ).then(res => {
      //   console.log('postlist=>', res.data);
      // }).catch((error) => {
      //   console.log('error=>', error)
      // });
      }
  }
</script>
