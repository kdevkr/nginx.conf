import { defineConfig } from "vite";
import vue from "@vitejs/plugin-vue";

// https://vitejs.dev/config/
export default defineConfig({
  build: {
    manifest: true,
    target: "esnext",
  },
  plugins: [vue()],
});
