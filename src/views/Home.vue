<template>
  <div>
    <v-container>
      <carousel/>
    </v-container>
  </div>
</template>

<script>
import carousel from '../components/carousel.vue'
  export default {
    name: 'Home',
    components: {
      carousel
    },
  }
</script>
