FROM node:18-alpine

EXPOSE 8080
EXPOSE 3000
EXPOSE 5000
EXPOSE 50000

WORKDIR /spotme-web/
COPY . ./
COPY public/ /spotme-web/public
COPY src/ /spotme-web/src
COPY package.json /spotme-web/

RUN npm install
RUN npm install -g serve
RUN npm run build

ENTRYPOINT ["serve","-s","build"]


