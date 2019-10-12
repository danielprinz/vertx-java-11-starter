package com.danielprinz.vertx.java11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;

public class MainVerticle extends AbstractVerticle {

  private static final Logger LOG = LoggerFactory.getLogger(MainVerticle.class);

  @Override
  public void start(Promise<Void> start) throws Exception {
    vertx.createHttpServer().requestHandler(req ->
      req.response()
        .putHeader("content-type", "text/plain")
        .end("Hello from Vert.x!")
    ).listen(8080, http -> {
      if (http.succeeded()) {
        start.complete();
        LOG.info("HTTP server started on http://localhost:8080");
      } else {
        start.fail(http.cause());
      }
    });
  }

  public static void main(String[] args) {
    final Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new MainVerticle());
  }
}
