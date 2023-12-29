<template>
   <div class="box">
     <div class="login-container">
       <div class="login-wrapper" style="width: 400px; height: 320px; margin-left: 500px; background-color:rgb(255,255,255); border-radius: 30px">
         <div style="width: 100%; height: 100px; font-size: 30px; font-weight: bold; line-height: 100px; text-align: center; color: #1d4359">
           欢迎注册账号
         </div>
         <div style="text-align: center; height: 320px;">
           <el-form :model="admin">
             <el-form-item>
               <el-input v-model="admin.name" prefix-icon="el-icon-user" style="width: 70%" placeholder="username"></el-input>
             </el-form-item>
             <el-form-item>
               <el-input v-model="admin.password" show-password prefix-icon="el-icon-lock" style="width: 70%" placeholder="password"></el-input>
             </el-form-item>

             <el-form-item>
               <el-button style="background-color: #1d4359; border: none; width: 70%; margin-top: 10px" type="primary" @click="register()">注 册</el-button>
             </el-form-item>
             <div style="text-align: center">
               <span style="color: #1d4359; font-size: 15px">已经有账号？</span><a href="javascript:void(0)" style="text-decoration: none; font-size: 15px" @click="navLogin">点击登录</a>
             </div>
           </el-form>
         </div>
       </div>
     </div>
   </div>
</template>

<script>

import request from "@/utils/request";

export default {
  name: "Register",
  data() {
    return {
      admin: {}
    }
  },
  // 页面加载的时候，做一些事情，在created里面
  created() {
  },
  // 定义一些页面上控件出发的事件调用的方法
  methods: {
    register() {
      request.post("/user/register", this.admin).then(res => {
        if (res.code === '0') {
          this.$message({
            message: '注册成功',
            type: 'success'
          });
          this.$router.push("/login");
        } else {
          this.$message({
            message: res.msg,
            type: 'error'
          });
        }
      })
    },
    navLogin() {
      this.$router.push("/login")
    }
  }
}
</script>

<style scoped>
.box {
  width: 100vw;
  height: 100vh;
  background-color: rgb(29, 67, 89);
}
.login-container {
//height: 100vh;
//overflow: hidden;
//background-image: url("@/assets/login_two.jpg");
//background-size: 100%;
//display: flex;
//align-items: center;
//justify-content: center;
  width: 75vw;
  height: 90vh;
  background-image: url("@/assets/login_two.jpg");
  background-size: 100% 100%;
  position: absolute;
  right: 15%;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  border-radius: 20px;
  background-color: #fff;
}
.login-wrapper {
  width: 25vw;
  position: absolute;
  right: 8%;
  top: 50%;
  transform: translateY(-50%);
}
</style>