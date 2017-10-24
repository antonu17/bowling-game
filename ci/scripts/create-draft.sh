#!/usr/bin/env sh

set -eux

TAG="$(git --git-dir=$GIT_DIR rev-parse HEAD)"
PR_ID=$(git --git-dir=$GIT_DIR config --get pullrequest.id)
PR_AUTHOR=$(git --git-dir=$GIT_DIR log -n 1 --pretty=format:'%an')

echo $TAG > $OUTPUT/tag
echo -e "PR: #${PR_ID}, by ${PR_AUTHOR}\nLast commit id: \`${TAG}\`" > $OUTPUT/body
