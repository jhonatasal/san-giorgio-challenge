#!/bin/bash -xe


function cmd_run_in_container() {
   docker rm -f postgres_container || true
   docker rm -f san-giorgio-api || true
   docker rmi san-giorgio-challenge-app || true
   docker compose up
}


cd "$(dirname "$0")"; _cmd="${1?"cmd is required"}"; shift; "cmd_${_cmd}" "$@"