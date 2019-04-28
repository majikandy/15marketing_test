FROM nginx

COPY build/test-results/test /user/share/nginx/html
