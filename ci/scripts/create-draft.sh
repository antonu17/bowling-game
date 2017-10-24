#!/usr/bin/env sh

set -eux

TAG="draft.$(git --git-dir=$GIT_DIR rev-parse HEAD)"
PR_ID=$(git --git-dir=$GIT_DIR config --get pullrequest.id)
PR_AUTHOR=$(git --git-dir=$GIT_DIR log -n 1 --pretty=format:'%an')

echo $TAG > $OUTPUT/tag
echo -e "PR: #${PR_ID}, by ${PR_AUTHOR}\nDeploy with: \`${TAG}\`" > $OUTPUT/body
