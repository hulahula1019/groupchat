<template>
  <div style="width: 50%; margin-top: 20px">
    <el-form :model="user">
      <el-form-item label="头像" label-width="15%">
        <el-upload action="http://localhost:8080/files/upload" ref="tx" :on-success="txSuccessUpload">
          <el-button size="small" type="success">点击上传</el-button>
        </el-upload>
      </el-form-item>
      <el-form-item label="姓名" label-width="15%">
        <el-input v-model="user.name" disabled autocomplete="off" style="width: 90%"></el-input>
      </el-form-item>
      <el-form-item label="性别" label-width="15%">
        <el-radio v-model="user.sex" label="男">男</el-radio>
        <el-radio v-model="user.sex" label="女">女</el-radio>
      </el-form-item>
      <el-form-item label="年龄" label-width="15%">
        <el-input v-model="user.age" autocomplete="off" style="width: 90%"></el-input>
      </el-form-item>
      <el-form-item label="电话" label-width="15%">
        <el-input v-model="user.phone" autocomplete="off" style="width: 90%"></el-input>
      </el-form-item>
    </el-form>
    <div style="text-align: center;">
      <el-button type="primary" @click="submit()">保 存</el-button>
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
      request.post("/user", this.user).then(res => {
        if (res.code === '0') {
          this.$message.success("操作成功");
          this.$bus.$emit('updateAvatar', this.user.avatar)
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
