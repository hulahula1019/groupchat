<template>
  <div>
    <div style="color: #5050bb; font-weight: bold; font-size: 20px">
      欢迎您 {{user.name}}， 您可以在聊天室畅所欲言！
    </div>
  </div>
</template>

<script>


export default {
  name: 'HomeView',

  data() {
    return {
      activeName: '1',
      data: [],
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}
    };
  },
  mounted() {

  },
  methods: {

  }
}
</script>

<style scoped>
.el-collapse-item__header {
  color: #344675 !important;
}
</style>
