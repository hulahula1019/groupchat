<template>
  <div style="width: 50%; margin-top: 20px">
    <el-form :model="user">
      <el-form-item label="原密码" label-width="15%">
        <el-input v-model="user.password" show-password autocomplete="off" style="width: 90%"></el-input>
      </el-form-item>
      <el-form-item label="新密码" label-width="15%">
        <el-input v-model="user.newPassword" show-password autocomplete="off" style="width: 90%"></el-input>
      </el-form-item>
      <el-form-item label="确认密码" label-width="15%">
        <el-input v-model="user.new2Password" show-password autocomplete="off" style="width: 90%"></el-input>
      </el-form-item>
    </el-form>
    <div style="text-align: center;">
      <el-button type="primary" @click="submit()">提 交</el-button>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  data() {
    return {
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}
    }
  },
  // 页面加载的时候，做一些事情，在created里面
  created() {
  },
  // 定义一些页面上控件出发的事件调用的方法
  methods: {
    submit() {
      if (!this.user.password) {
        this.$message.warning("请输入原密码")
        return
      }
      if (!this.user.newPassword) {
        this.$message.warning("请输入新密码")
        return
      }
      if (!this.user.new2Password) {
        this.$message.warning("请确认新密码")
        return
      }
      if (this.user.newPassword !== this.user.new2Password) {
        this.$message.warning("两次输入的密码不一致")
        return
      }
      request.post("/user/password", this.user).then(res => {
        if (res.code === '0') {
          this.$message.success("修改成功");
          localStorage.removeItem("user");
          this.$router.push("/login")
        } else {
          this.$message.error(res.msg);
        }
      })
    },
    txSuccessUpload(res) {
      this.user.avatar = res.data;
    }
  }
}
</script>
