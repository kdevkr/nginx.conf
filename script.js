import http from "k6/http";
import { check, sleep } from "k6";

export const options = {
  hosts: { "mambo.kr": "127.0.0.1" },
  tlsVersion: {
    min: http.TLS_1_2,
    max: http.TLS_1_3,
  },
  stages: [
    { duration: "30s", target: 20 },
    { duration: "1m30s", target: 10 },
    { duration: "20s", target: 0 },
  ],
};

export default function () {
  const res = http.get("https://mambo.kr");
  check(res, {
    "status was 200": (r) => r.status === 200,
    "protocol is HTTP/2": (r) => r.proto === "HTTP/2.0",
  });
  sleep(0.1);
}
