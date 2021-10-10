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
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>

      <template v-slot:extension>
        <v-tabs align-with-title >
          <v-tab>主页</v-tab>
          <v-tab>足球</v-tab>
          <v-tab>篮球</v-tab>
          <v-tab>论坛</v-tab>
        </v-tabs>
      </template>
    </v-app-bar>
</template>

<script>

export default {
  name: 'appBar',

  data: () => ({
     items: [
        { title: '个人主页' },
        { title: '我的猜测' },
      ],
  }),
};
</script>