variable "default_project" {
  default = "cloudtomation"
}

variable "default_region" {
  default = "us-central1"
}

provider "google" {
  credentials = "${file("cloudtomation.json")}"
  project = "${var.default_project}"
  region = "${var.default_region}"
}

data "google_container_registry_image" "selenium-hub-image" {
  name = "selenium-hub"
}

resource "google_container_cluster" "selenium-hub-cluster" {
  name = "selenium-hub-cluster"
  initial_node_count = 1
  remove_default_node_pool = true
  location = "us-central1-f"
}

resource "google_container_node_pool" "selenium-hub-pool" {
  name = "selenium-hub-pool"
  location = "us-central1-f"
  cluster = "${google_container_cluster.selenium-hub-cluster.name}"
  node_count = 1
}

