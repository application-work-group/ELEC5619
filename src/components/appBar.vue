<template>
        <v-app-bar
      app
      dark
      src="https://i.pinimg.com/originals/a9/88/a4/a988a47e605cacc02b0bb41c85270de3.jpg"
    >

      <v-toolbar-title>
        Sport live
      </v-toolbar-title>
      
      <v-spacer></v-spacer>

      <v-menu offset-y>
        <template v-slot:activator="{ on, attrs }">      
          <v-btn icon 
          v-bind="attrs"
          v-on="on">
            <v-icon>mdi-account-circle</v-icon>
          </v-btn>
        </template>
        <v-list>
          <v-list-item
            v-for="(item, index) in items"
            :key="index"
          >
            <v-list-item-title @click="pageRedirect(item.title)">{{ item.title }}</v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>

      <template v-slot:extension>
        <v-tabs align-with-title >
          <v-tab v-for="tab in tabs" 
                :key="tab.name" 
                :to="{name: tab.name, params: {category:tab.text}}"
          >
            {{tab.text}}
          </v-tab>
        </v-tabs>
      </template>
    </v-app-bar>
</template>

<script>

export default {
  name: 'appBar',

  data: () => ({
     items: [
        { title: 'profile' },
        { title: '我的猜测' },
      ],
      tabs: [
        { name: "home", text: "home" }, 
        { name: "football", text: "football" },
        { name: "category", text: "basketball" },
      ],
  }),
  methods:{
    pageRedirect(index){
      this.$router.push({name: index})
    }
  }
};
</script>