# Nginx Configuration

- Nginx 1.21.3
- Amazon Corretto 11

## Features

- HTTPS Redirect
- Reverse Proxy
- SSL Termination
- Static Files

## Run as

```sh
# Start Containers using Docker-Compose
docker compose up -d

# Reload Nginx Configuration
docker compose exec nginx nginx -s reload
```

## SSL Certificate

server.crt is self signed certificate.

```sh
openssl x509 -in server.crt -text -noout
Certificate:
    Data:
        Version: 3 (0x2)
        Serial Number:
            66:ab:bb:ed:19:f3:c7:37:9d:d6:5d:29:da:03:7d:b9:4f:53:7c:b7
        Signature Algorithm: ecdsa-with-SHA256
        Issuer: C = KO, ST = None, L = None, O = None, CN = CA
        Validity
            Not Before: Aug 27 11:27:54 2021 GMT
            Not After : Sep 29 11:27:54 2022 GMT
        Subject: C = KO, ST = None, L = None, O = None, CN = localhost
        Subject Public Key Info:
            Public Key Algorithm: id-ecPublicKey
                Public-Key: (256 bit)
                pub:
                    04:74:06:a3:39:91:2e:4b:cc:45:40:e8:b0:f8:a3:
                    96:69:91:66:ef:d3:b3:93:8d:e5:09:78:aa:a5:af:
                    67:9d:47:13:78:54:7e:d9:02:ba:e4:ca:aa:d4:9f:
                    8b:f3:be:d7:40:1e:f5:c4:8d:7a:23:5b:09:c3:57:
                    75:38:7e:4d:e6
                ASN1 OID: prime256v1
                NIST CURVE: P-256
        X509v3 extensions:
            X509v3 Authority Key Identifier:
                DirName:/C=KO/ST=None/L=None/O=None/CN=CA
                serial:5D:98:7B:BF:10:35:6B:9C:11:97:2C:AC:21:E3:28:C2:FF:AF:2D:3D

            X509v3 Subject Alternative Name:
                IP Address:127.0.0.1, DNS:localhost, DNS:mambo.kr
    Signature Algorithm: ecdsa-with-SHA256
         30:46:02:21:00:ce:5d:3a:68:e9:04:dc:a9:fd:e6:14:de:bb:
         11:5c:5a:a1:bf:b4:f9:1a:61:08:cd:da:47:d1:b4:68:80:81:
         d1:02:21:00:e7:a1:b4:cb:06:6d:ad:80:d3:89:09:c1:1e:ca:
         6e:c7:2e:14:fd:99:d9:df:44:14:cb:47:39:df:ea:5e:e0:1e
```

### Generate certificate using mkcert

[mkcert.dev](https://mkcert.dev)

```sh
mkcert -install
mkcert -key-file server.key -cert-file server.crt localhost 127.0.0.1 mambo.kr
```

## Build Vite

```sh
yarn --cwd 'frontend' install
yarn --cwd 'frontend' run build --mode production
```

## Load Test with k6

```sh
k6 run script.js
```
