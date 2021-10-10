<template>
  <v-app>
    <appBar/>
    <v-main fluid>
      <router-view/>
    </v-main>
  </v-app>
</template>

<script>
import appBar from '../src/components/app_bar.vue'
export default {
  name: 'App',
  data: () => ({

  }),
  components:{
    appBar
  }
};
</script>
