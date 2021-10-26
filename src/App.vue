<template>
  <v-app>
    <appBar/>
    <v-main>
      <router-view :key="$route.path"/>
    </v-main>
    <appFooter/>
  </v-app>
</template>

<script>
import appBar from './components/appBar.vue'
import appFooter from './components/appFooter.vue'
export default {
  name: 'App',
  data: () => ({

  }),
  components:{
    appBar,
    appFooter
  }
};
</script>
